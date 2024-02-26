#!/usr/bin/python3
""" activity routes """

from flask import Blueprint

activity_bp = Blueprint("activity_bp", __name__)

@activity_bp.route("/v1.0.0/activities", methods=["GET"])
def get_activities():
    """ returns all activitites """

    return "all activities activities"

@activity_bp.route("/v1.0.0/activities/<string:id>", methods=["GET"])
def get_activity(id=id):
    """ gets a single activity"""

    return "one activity"

@activity_bp.route("/v1.0.0.0/activities", methods=["POST"])
def create_activity():
    """ Creates an activity """

    return "create activity"

@activity_bp.route("/v1.0.0/activities/<string:id>", methods=["DELETE"])
def delete_activity():
    """ deletes a task """

    return "delete task"
    
@activity_bp.route("/v1.0.0/activities/<string:id>", methods=["PUT"])
def update_activity():
    """ Updates an activity """

    return "update activity"
