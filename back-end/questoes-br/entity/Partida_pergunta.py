from pydantic import BaseModel
from typing import Optional

class partida_pergunta(BaseModel):
    id: Optional[int] = None
    partida_id: Optional[int] = None
    pergunta_id: Optional[int] = None