from pydantic import BaseModel
from typing import Dict, Any, Optional

class pergunta(BaseModel):
    id: Optional[int] = None
    categoria_pergunta: str
    texto_pergunta: str
    alternativas: dict[str, Any]
    resposta_correta: str
