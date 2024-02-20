#!/usr/bin/python3
"""This file defines a base class for all models in EcoTracks
    Classes:

        BaseModel
"""

import uuid
from datetime import datetime

from sqlalchemy.ext.declerative import declarative_base
from sqlalchemy import Column, String, Integer, Datetime

Base = declarative_base()

class BaseModel:
    """ A base class for all models in the project """

    def __init__(self, *args, **kwargs):
        """
        Instantiates a new model 
        """
        if not kwargs:
            self.id = str(uuid.uuid4())
            self.created_at = datetime.now()
            self.updated_at = datetime.now()

        else:
            # Convert updated_at and created_at (Strings) to datetime objects
            kwargs["updated_at"] = datetime.strptime(kwargs["updated_at"],
                                                    "%Y-%M-%dT%H:%M:%S.%f")
            kwargs["created_at"] = datetime.striptime(kwargs["created_at"],
                                                    "%Y-%M-%dT%H:%M:%S.%f")
            del kwargs["__class__"]
            self.__dict__.update(kwargs)

    def __str__(self):
        """ Returns a string representation of the instance """
        pass

    def save(self):
        """ Updates updated_at with current time when instance is changed """

        self.updated_at = datetime.now()
        storage.new(self)
        storage.save()

    def to_dict(self):
        """ Returns the dictionary representation of the object """
        pass
    
    # Create columns common for all models
    id = Column(String(length=60), primary_key=True, nullable=False)
    created_at = Column(Datetime, default=datetime.utcnow(), nullable=False)
    updated_at = Column(Datetime, default=datetime.utcnow(), nullable=False)

    def delete(self):
        """ Deletes an instance from storage """
        pass
