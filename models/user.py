"""
    Classes:
    User
"""

from sqlalchemy import Column, String, Integer
from sqlalchemy.orm import relationship

from models.base_model import BaseModel, Base

class User(BaseModel, Base):
    """ User class """

    __tablename__ = 'users'

    name = Column("name", String(255), nullable=False)
    email = Column("email", String(255), nullable=False)
    password = Column("password", String(255), nullable=False)
    points_earned = Column("points_earned", Integer, default=0)

    activities = relationship("Activity", secondary="user_activity_log", back_populates="users")
