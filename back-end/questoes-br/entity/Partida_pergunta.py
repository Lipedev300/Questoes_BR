from pydantic import BaseModel
from typing import Optional

class partida_pergunta(BaseModel):
    id: Optional[int] = None
    id_partida: int = None
    pergunta_id: int = None
    status_partida: Optional[str] = None
    resposta_jogador: Optional[str] = None
    acertou: Optional[bool] = False