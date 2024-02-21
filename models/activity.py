"""
Classes:
    Activity
"""
from sqlalchemy import Column, String, Integer, Float, Table, ForeignKey
from sqlalchemy.orm import relationship

from models.base_model import BaseModel, Base

user_activity_log = Table(
            "user_activity_log", Base.metadata,
            Column("user_id", String(60), ForeignKey("users.id")),
            Column("activity_id", String(60), ForeignKey("activities.id"))
        )

class Activity(BaseModel, Base):
    """ Activity class """

    __tablename__ = "activities"

    name = Column("name", String(255), nullable=False)
    description = Column("description", String(510))
    points = Column("points", Integer, nullable=False)
    carbon_saving_factor = Column("carbon_saving_factor", Float)

    users = relationship("User", secondary=user_activity_log, back_populates="activities")
