from rest_framework import serializers
from .models import Evento, Invitado, Encuesta


class InvitadosSerializer(serializers.ModelSerializer):
    """Serializando invitados para incluirlos en eventos"""
    class Meta:
        model = Invitado
        fields = '__all__'


class EncuestaSerializer(serializers.ModelSerializer):
    class Meta:
        model = Encuesta
        fields = '__all__'


class EventoSerializer(serializers.ModelSerializer):

    invitados = InvitadosSerializer(many=True, read_only=True)
    encuesta = EncuestaSerializer(read_only=True)

    class Meta:
        model = Evento
        fields = ('id', 'nombre', 'ubicacion', 'fecha', 'invitados', 'encuesta')


