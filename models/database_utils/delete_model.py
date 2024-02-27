#!/usr/bin/python3

"""
    Function:
        delete_model
"""

from models.user import User
from models.activity import Activity
from models.activity_type import ActivityType
from models.user_activity_log import UserActivityLog

from . import storage

def delete_model(cls=None, id=None):
    """ Deletes a model from the database """

    if cls and id:
        cls = globals()[cls]
        to_delete = storage.one(cls, id)

        storage.delete(to_delete)

    return to_delete
