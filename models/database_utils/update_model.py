#!/usr/bin/python3

"""
    Function:
        update_model
"""
from models.user import User
from models.activity import Activity
from models.activity_type import ActivityType
from models.user_activity_log import UserActivityLog

from . import storage


def update_model(cls=None, id=None, to_update=None):
    """ Updates value of an object in the database """

    if cls and id:
        cls = globals()[cls]
        updated_model = storage.update(cls, id, to_update)

    return updated_model
