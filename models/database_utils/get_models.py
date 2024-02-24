#!/usr/bin/python3

"""
    Function:
        get_models
"""
from models.user import User
from models.activity import Activity
from models.activity_type import ActivityType
from models.user_activity_log import UserActivityLog

from . import storage

def get_models(cls=None, id=None):

    """ Gets an instance or all instances from the database """

    if cls and id:
        # Get all objects of the class

        model = storage.one(globals()[cls], id)
    
    elif cls and not id:
        model = storage.all(globals()[cls])

    return model
