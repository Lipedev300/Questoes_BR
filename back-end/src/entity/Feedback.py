from pydantic import BaseModel

class Feedback(BaseModel):
    id_mensagem: int
    id_jogador: int
    nome_usuario_jogador: str
    nome_completo_jogador: str
    assunto: str
    mensagem: str