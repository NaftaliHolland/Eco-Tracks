"""
    Classes:
    ActivityType
"""

from sqlalchemy import Column, String

from models.base_model import BaseModel, Base

class ActivityType(BaseModel, Base):
    """ represents activity types """

    __tablename__ = "activity_types"

    name = Column(String(255), nullable=False)
    description = Column(String(510))
