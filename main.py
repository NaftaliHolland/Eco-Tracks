#!/usr/bin/python3

""" Tests stuff """

from models.engine import StorageEngine
from models.user import User
from models.activity import Activity

from models.base_model import BaseModel

model = BaseModel()
activity = Acitivity()
storage = StorageEngine()

act_v = dict()

act_v["name"] = "Tree planting"
act_v["email"] = "muirumoses@gmail.com"
act_v["password"] = "muiru_password"
act_v["points_earned"] = 24

print(act_v)
for key, value in act_v.items():
    setattr(user, key, value)

storage.reload()
storage.new(user)
storage.save()

print(user)
print(user.id)

print(model.id)
