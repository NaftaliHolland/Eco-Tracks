#!/usr/bin/python3
""" User routes """

from flask import Blueprint
from flask import jsonify
from flask import request

from models.database_utils.get_models import get_models
from models.database_utils.create_model import create_model
from models.database_utils.update_model import update_model

user_bp = Blueprint("user_bp", __name__)


@user_bp.route("/v1.0.0/users", methods=["GET"])
def get_users():
    """ returns all users """

    response = get_models(cls="User")
    users = dict()

    for key, value in response.items():
        users[key] = value.name

    return jsonify(users)

@user_bp.route("/v1.0.0/users/<string:id>", methods=["GET"])
def get_user(id):
    """ returns a user with id=id """

    user_dict = dict()
    user = get_models(cls="User", id=id)
    
    user_dict["name"] = user.name
    user_dict["email"] = user.email
    user_dict["id"] = user.id
    user_dict["created_at"] = user.created_at
    user_dict["updated_at"] = user.updated_at
    user_dict["points_earned"] = user.points_earned

    return jsonify(user_dict)

@user_bp.route("/v1.0.0/users", methods=["POST"])
def create_user():
    """ creates a user """
    if not request.json:
        abort(400)
    user_dict = {
            "name": request.json["name"],
            "email": request.json["email"],
            "password": request.json["password"]
            }
    user = create_model(user_dict, cls="User")
    print(user)
    print(type(user))

    return jsonify(user_dict)

@user_bp.route("/v1.0.0/users/<string:id>", methods=["DELETE"])
def delete_user():
    """ Deletes a user """

    return "delete user"

@user_bp.route("/v1.0.0/users/<string:id>", methods=["PUT"])
def update_user():
    """ Updates a user """

    user_dict = dict()

    user = updated_model(id=id, to_update=request.json, cls="User")

    
    return "update user"
