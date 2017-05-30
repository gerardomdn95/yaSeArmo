from django.shortcuts import get_object_or_404
from .serializers import InvitadosSerializer, EventoSerializer, EncuestaSerializer, UserSerializer
from .models import Evento, Invitado, Encuesta
from rest_framework.response import Response
from rest_framework.views import APIView
from rest_framework.parsers import FormParser, MultiPartParser
from django.conf import settings
from rest_framework import generics, filters, status
from django.contrib.auth.models import User


class ListEventos(APIView):

    def get(self, request):
        eventos = Evento.objects.all()
        serializer = EventoSerializer(eventos, many=True)
        return Response(serializer.data, status=status.HTTP_200_OK)

    def post(self, request):
        serializer = EventoSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        else:
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


class DetailEvento(APIView):
    def get(self, request, pk):
        evento = get_object_or_404(Evento, id=pk)
        serializer = EventoSerializer(evento)
        return Response(serializer.data, status=status.HTTP_200_OK)

    def put(self, request, pk):
        evento = get_object_or_404(Evento, id=pk)
        serializer = EventoSerializer(evento, data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_200_OK)
        else:
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def delete(self, request, pk):
        evento = get_object_or_404(Evento, id=pk)
        evento.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)


class ListInvitados(APIView):

    def get(self, request):
        invitados = Invitado.objects.all()
        print("INVITADOS####################################")
        print(invitados[0].user.last_name)
        serializer = InvitadosSerializer(instance=invitados, many=True, read_only=True)
        return Response(serializer.data, status=status.HTTP_200_OK)

    def post(self, request):
        serializer = InvitadosSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        else:
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


class DetailInvitados(APIView):
    def get(self, request, pk):
        invitados = get_object_or_404(Invitado, id=pk)
        serializer = InvitadosSerializer(invitados)
        return Response(serializer.data, status=status.HTTP_200_OK)

    def put(self, request, pk):
        invitados = get_object_or_404(Invitado, id=pk)
        serializer = InvitadosSerializer(invitados, data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_200_OK)
        else:
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def delete(self, request, pk):
        invitados = get_object_or_404(Invitado, id=pk)
        invitados.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)


class ListEncuestas(APIView):

    def get(self, request):
        encuesta = Encuesta.objects.all()
        serializer = EncuestaSerializer(encuesta, many=True)
        return Response(serializer.data, status=status.HTTP_200_OK)

    def post(self, request):
        serializer = EncuestaSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        else:
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


class DetailEncuesta(APIView):
    pass


class ListUsers(APIView):

    def get(self, request):
        user = User.objects.all()
        serializer = UserSerializer(user, many=True)
        return Response(serializer.data, status=status.HTTP_200_OK)


class UploadFiles(APIView):
    parser_classes = (FormParser, MultiPartParser)

    def handle_upload_file(self, f):
        path = "%s/%s" % (settings.MEDIA_ROOT, str(f))
        with open(path, 'wb+') as destination:
            for chunk in f.chunks():
                destination.write(chunk)

    def post(self, request):
        try:
            self.handle_upload_file(request.FILES['file'])
        except:
            return Response(status=status.HTTP_500_INTERNAL_SERVER_ERROR)

        return Response(status=status.HTTP_200_OK)