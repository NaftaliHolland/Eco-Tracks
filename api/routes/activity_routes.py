#!/usr/bin/python3
""" activity routes """

from flask import Blueprint
from flask import jsonify
from flask import request

from models.database_utils.get_models import get_models
from models.database_utils.create_model import create_model
from models.database_utils.update_model import update_model
from models.database_utils.delete_model import delete_model

activity_bp = Blueprint("activity_bp", __name__)

@activity_bp.route("/v1.0.0/activities", methods=["GET"])
def get_activities():
    """ returns all activitites """

    response = get_models(cls="Activity")
    activities = dict()

    for key, value in response.items():
        activities[key] = value.name

    return jsonify(activities)

@activity_bp.route("/v1.0.0/activities/<string:id>", methods=["GET"])
def get_activity(id):
    """ gets a single activity"""

    activity = get_models(cls="Activity", id=id)
    
    activity_dict = {
            "id": activity.id,
            "name": activity.name,
            "description": activity.description,
            "created_at": activity.created_at,
            "updated_at": activity.updated_at,
            "points": activity.points,
            "carbon_saving_factor": activity.carbon_saving_factor
        }

    return jsonify(activity_dict)

@activity_bp.route("/v1.0.0.0/activities", methods=["POST"])
def create_activity():
    """ Creates an activity """

    if not request.json:
        abort(400)

    activity_dict = {
            "name": request.json["name"],
            "description": request.json["description"],
            "points": request.json["points"],
            "carbon_saving_factor": request.json["carbon_saving_factor"]
            }

    activity = create_model(activity_dict, cls="Activity")

    activity_dict1 = {
            "id": activity.id,
            "name": activity.name,
            "description": activity.description,
            "created_at": activity.created_at,
            "updated_at": activity.updated_at,
            "points": activity.points,
            "carbon_saving_factor": activity.carbon_saving_factor
        }

    return jsonify(activity_dict)

@activity_bp.route("/v1.0.0/activities/<string:id>", methods=["DELETE"])
def delete_activity():
    """ deletes a task """

    activity = delete_model(cls="Activity", id=id)
    activity_dict = {
            "id": activity.id,
            "name": activity.name,
            "description": activity.description,
            "created_at": activity.created_at,
            "updated_at": activity.updated_at,
            "points": activity.points,
            "carbon_saving_factor": activity.carbon_saving_factor
        }

    return jsonify(activity_dict)
    
@activity_bp.route("/v1.0.0/activities/<string:id>", methods=["PUT"])
def update_activity():
    """ Updates an activity """
    activity = updated_model(id=id, to_update=request.json, cls="Activity")

    activity_dict = {
            "id": activity.id,
            "name": activity.name,
            "description": activity.description,
            "created_at": activity.created_at,
            "updated_at": activity.updated_at,
            "points": activity.points,
            "carbon_saving_factor": activity.carbon_saving_factor
        }

    return jsonify(activity_dict)
