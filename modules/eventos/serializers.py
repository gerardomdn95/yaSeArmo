from rest_framework import serializers
from .models import Evento, Invitado, Encuesta


class InvitadosSerializer(serializers.ModelSerializer):  # DUDA: ¿Cómo serializar invitados con el modelo de usuarios?
    """Serializando invitados para incluirlos en eventos"""
    class Meta:
        model = Invitado
        fields = '__all__'  # ERROR: Despliega solo id, imagen y user(numero)
        # fields = ('user.first_name', 'user.last_name', 'imagen')

"""
class OpcionesSerializer(serializers.ModelSerializer):  # DUDA: ¿Esto es correcto?
    class Meta:
        model = Encuesta.opciones
        fields = '__all__'"""


class EncuestaSerializer(serializers.ModelSerializer):  # DUDA: Marca error si no serializo opciones
    # opciones = OpcionesSerializer(read_only=True, many=True)  # DUDA: ¿Esto es correcto?

    class Meta:
        model = Encuesta
        fields = ('id', 'opciones', 'tiempo_fin')  # ERROR: en opciones


class EventoSerializer(serializers.ModelSerializer):

    invitados = InvitadosSerializer(read_only=True, many=True)
    encuesta = EncuestaSerializer(read_only=True)

    class Meta:
        model = Evento
        fields = ('id', 'nombre', 'ubicacion', 'fecha', 'invitados', 'encuesta')
        # ERROR: despliega solo un invitado en ligar de varios


