from django.shortcuts import get_object_or_404
from .serializers import InvitadosSerializer, EventoSerializer, EncuestaSerializer
from .models import Evento, Invitado, Encuesta
from rest_framework.response import Response
from rest_framework.views import APIView
from rest_framework.parsers import FormParser, MultiPartParser
from django.conf import settings
from rest_framework import generics, filters, status


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

#TODO: DetailEvento


class ListInvitados(APIView):

    def get(self, request):
        invitados = Invitado.objects.all()
        serializer = InvitadosSerializer(invitados, many=True)
        return Response(serializer.data, status=status.HTTP_200_OK)

    def post(self, request):
        serializer = InvitadosSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        else:
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


class ListEncuesta(APIView):

    def get(self, request):
        encuesta = Encuesta.objects.all()
        serializer = EncuestaSerializer(encuesta)
        return Response(serializer.data, status=status.HTTP_200_OK)

    def post(self, request):
        serializer = EncuestaSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        else:
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


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