from django.shortcuts import render
from .models import Pedidos, Paquetes, Productos
from .serializers import PedidosSerializer, PaquetesSerializer, ProductosSerializer
from rest_framework.parsers import FormParser, MultiPartParser
from rest_framework.views import APIView
from rest_framework.response import Response
from django.conf import settings
from rest_framework import generics, filters, status


class ListProductos(generics.ListCreateAPIView):
    queryset = Productos.objects.all()
    serializer_class = ProductosSerializer


class ListPaquetes(generics.ListCreateAPIView):
    queryset = Paquetes.objects.all()
    serializer_class = PaquetesSerializer


class ListPedidos(generics.ListCreateAPIView):
    queryset = Pedidos.objects.all()
    serializer_class = PedidosSerializer


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