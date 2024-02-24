#!/usr/bin/python3

"""
    Function:
        create_model
"""

from models.user import User
from models.activity import Activity
from models.activity_type import ActivityType
from models.user_activity_log import UserActivityLog

from . import storage


def create_model(model_attrs, cls=None):

    """ Creates an object of class cls with attributes
        in kwargs and saves it to a database
    """

    print(cls)
    if cls:
        cls = globals()[cls]
        print(cls.__name__)
        instance = cls()

        for key, value in model_attrs.items():
            setattr(instance, key, value)

        storage.new(instance)
        storage.save()

        return instance
