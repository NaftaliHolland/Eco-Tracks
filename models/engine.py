"""
    Storage engine

    Classes:
        StorageEngine
"""
from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker
from sqlalchemy.orm import scoped_session

import os
from models.user import User
from models.activity import Activity
from models.activity_type import ActivityType
from datetime import datetime

from models.base_model import Base

class StorageEngine:
    """ Manages the database storage """

    __engine = None
    __session = None

    def __init__(self):
        """ Initializes everything and creates and engine """

        # get attributes from environment variables
        user = os.environ["ECO_MYSQL_USER"]
        password = os.environ["ECO_MYSQL_PWD"]
        host = os.environ["ECO_MYSQL_HOST"]
        database = os.environ["ECO_MYSQL_DB"]

        # create engine

        self.__engine = create_engine(
                    f"mysql+mysqldb://{user}:{password}@{host}:3306/{database}",
                    pool_pre_ping=True
                )
        if os.environ.get("ECO_ENV") == "test":
            Base.metadata.drop_all(self.__engine)


    def all(self, cls=None):
        """ Queries the current database session for all objects of the class cls """

        return_result = dict()
        result = list()

        # Create session factory
        Session = sessionmaker(bind=self.__engine)
        
        # create session
        self.__session = Session()
        
        # query

        if not cls:
            # query all tables
            result = self.__session.query(User).all()
            for table_name, table in Base.metadata.tables.items():
                result.extend(self.__session.query(table).all())

        else:
            # query objects of the given class
            result = self.__session.query(cls).all()

        
        # create dictionary of objects
        for obj in result:
            key = obj.__class__.__name__ + '.' + obj.id
            return_result[key] = obj

        return return_result

    def one(self, cls=None, id=None):
        """ Queries the database and returns one instance with the id == id"""

        return_result = dict()
        result = self.__session.query(cls).get(id)

        return result 

    def new(self, obj):
        """ Adds object obj to the current database session """

        if obj:
            self.__session.add(obj)

    def save(self):
        """ Commits all changes of the current database session """

        self.__session.commit()

    def delete(self, obj=None):
        """ Deletes objj from the current database session """
        if obj:
            self.__session.delete()

    def update(self, cls=None, id=None, to_update=None):
        """ Updates an object """
        obj_to_update = self.one(cls, id)

        if obj_to_update:
            for key, value in to_update.items():
                setattr(obj_to_update, key, value)
                setattr(obj_to_update, "updated_at", datetime.now())

        self.__session.commit()
        return obj_to_update


    def reload(self):
        """ Creates tables in the database """

        Base.metadata.create_all(self.__engine)

        session_factory = sessionmaker(bind=self.__engine, expire_on_commit=False)
        Session = scoped_session(session_factory)
        self.__session = Session
