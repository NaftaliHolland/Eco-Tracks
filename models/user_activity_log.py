"""
    Classes:
        UserActivityLog
"""

from sqlalchemy import Column, String, ForeignKey
from models.base_model import BaseModel, Base

class UserActivityLog(BaseModel, Base):
    """ Represents a relationship table between a user and an activity """

    __tablename__ = "user_activity_log"

    user_id = Column("user_id", String(60), ForeignKey("users.id"))
    activity_id = Column("activity_id", String(60), ForeignKey("activities.id"))
