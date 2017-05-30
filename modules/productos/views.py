from django.shortcuts import render
from .models import Pedidos, Paquetes, Productos
from .serializers import PedidosSerializer, PaquetesSerializer, ProductosSerializer
from rest_framework.parsers import FormParser, MultiPartParser
from rest_framework.views import APIView
from rest_framework.response import Response
from django.conf import settings
from rest_framework import generics, filters, status


class ListProductos(APIView):

    def get(self, request):
        productos = Productos.objects.all()
        serializer = ProductosSerializer(productos, many=True)
        return Response(serializer.data, status=status.HTTP_200_OK)

    def post(self, request):
        serializer = ProductosSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        else:
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


class ListPaquetes(APIView):

    def get(self, request):
        paquetes = Paquetes.objects.all()
        serializer = PaquetesSerializer(paquetes, many=True)
        return Response(serializer.data, status=status.HTTP_200_OK)

    def post(self, request):
        serializer = PaquetesSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        else:
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


class ListPedidos(APIView):

    def get(self, request):
        pedidos = Pedidos.objects.all()
        serializer = PedidosSerializer(pedidos, many=True)
        return Response(serializer.data, status=status.HTTP_200_OK)

    def post(self, request):
        serializer = PedidosSerializer(data=request.data)
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