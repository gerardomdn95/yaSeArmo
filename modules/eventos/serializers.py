from rest_framework import serializers
from .models import Evento, Invitado, Encuesta
from django.contrib.auth.models import User


class UserSerializer(serializers.ModelSerializer):
    class Meta:
        model = User
        fields = ('username', 'first_name', 'last_name', 'email')


class InvitadoSerializer(serializers.ModelSerializer):
    """Serializando invitados para incluirlos en eventos"""
    user = UserSerializer(read_only=True)

    class Meta:
        model = Invitado
        fields = ('id', 'user', 'imagen')


class EncuestaSerializer(serializers.ModelSerializer):

    class Meta:
        model = Encuesta
        fields = ('id', 'opciones', 'tiempo_fin')


class EventoSerializer(serializers.ModelSerializer):

    invitados = InvitadoSerializer(read_only=True, many=True)
    encuesta = EncuestaSerializer(read_only=True)

    class Meta:
        model = Evento
        fields = ('id', 'nombre', 'ubicacion', 'fecha', 'invitados', 'encuesta')



