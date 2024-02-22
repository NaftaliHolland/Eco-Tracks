"""
Classes:
    Activity
"""
from sqlalchemy import Column, String, Integer, Float, Table, ForeignKey
from sqlalchemy.orm import relationship

from models.base_model import BaseModel, Base

class Activity(BaseModel, Base):
    """ Activity class """

    __tablename__ = "activities"

    name = Column("name", String(255), nullable=False)
    description = Column("description", String(510))
    points = Column("points", Integer, nullable=False)
    carbon_saving_factor = Column("carbon_saving_factor", Float)
    activity_type_id = Column("activity_type_id", String(60), ForeignKey("activity_types.id"))
    activity_type = relationship("ActivityType", back_populates="activities")

    users = relationship("User", secondary="user_activity_log", back_populates="activities")
