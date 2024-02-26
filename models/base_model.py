#!/usr/bin/python3
"""This file defines a base class for all models in EcoTracks
    Classes:

        BaseModel
"""

import uuid
from datetime import datetime
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy import Column, String, Integer, DateTime

Base = declarative_base()

class BaseModel:
    """ A base class for all models in the project """

    def __init__(self, *args, **kwargs):
        """ Instanciates a new model """

        if not kwargs:
            self.id = str(uuid.uuid4())
            self.created_at = datetime.now()
            self.updated_at = datetime.now()
        else:
            kwargs["updated_at"] = datetime.strptime(kwargs["updated_at"],
                                                    "%Y-%m-%dT%H:%M:%S.%f")
            kwargs["created_at"] = datetime.striptime(kwargs["created_at"],
                                                    "%Y-%m-%dT%H:%M:%S.%f")
            del kwargs["__class__"] #TODO why delete this

    def to_dict(self):
        """ returns dictionary representation of object """
        return self.__dict__

    def __str__(self):
        """ Returns a string representation of the instance """
        return "<{}(id={}, created_at={}, updated_at={})>".format(
                            self.__class__.__name__,
                            self.id,
                            self.created_at,
                            self.updated_at
                        )

    # Create columns common for all models
    id = Column(String(length=60), primary_key=True, nullable=False)
    created_at = Column(DateTime, default=datetime.utcnow(), nullable=False)
    updated_at = Column(DateTime, default=datetime.utcnow(), nullable=False)

    
