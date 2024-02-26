"""
    Classes:
    ActivityType
"""

from sqlalchemy import Column, String
from sqlalchemy.orm import relationship

from models.base_model import BaseModel, Base

class ActivityType(BaseModel, Base):
    """ represents activity types """

    __tablename__ = "activity_types"

    name = Column(String(255), nullable=False)
    description = Column(String(510))
    activities = relationship("Activity", back_populates="activity_type", cascade="all, delete-orphan")
