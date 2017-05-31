from django.shortcuts import get_object_or_404
from .serializers import ProductoSerializer, PedidoSerializer, PaqueteSerializer
from .models import Pedidos, Paquetes, Productos
from .serializers import PedidoSerializer, PaqueteSerializer, ProductoSerializer
from rest_framework.parsers import FormParser, MultiPartParser
from rest_framework.views import APIView
from rest_framework.response import Response
from django.conf import settings
from rest_framework import generics, filters, status


class ListProductos(APIView):

    def get(self, request):
        productos = Productos.objects.all()
        serializer = ProductoSerializer(productos, many=True)
        return Response(serializer.data, status=status.HTTP_200_OK)

    def post(self, request):
        serializer = ProductoSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        else:
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


class DetailProductos(APIView):
    def get(self, request, pk):
        producto = get_object_or_404(Productos, id=pk)
        serializer = ProductoSerializer(producto)
        return Response(serializer.data, status=status.HTTP_200_OK)

    def put(self, request, pk):
        producto = get_object_or_404(Productos, id=pk)
        serializer = ProductoSerializer(producto, data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_200_OK)
        else:
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def delete(self, request, pk):
        producto = get_object_or_404(Productos, id=pk)
        producto.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)


class ListPaquetes(APIView):

    def get(self, request):
        paquetes = Paquetes.objects.all()
        serializer = PaqueteSerializer(paquetes, many=True)
        return Response(serializer.data, status=status.HTTP_200_OK)

    def post(self, request):
        serializer = PaqueteSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        else:
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


class DetailPaquetes(APIView):
    
    def get(self, request, pk):
        paquete = get_object_or_404(Paquetes, id=pk)
        serializer = PaqueteSerializer(paquete)
        return Response(serializer.data, status=status.HTTP_200_OK)

    def put(self, request, pk):
        paquete = get_object_or_404(Paquetes, id=pk)
        serializer = PaqueteSerializer(paquete, data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_200_OK)
        else:
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def delete(self, request, pk):
        paquete = get_object_or_404(Paquetes, id=pk)
        paquete.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)


class ListPedidos(APIView):

    def get(self, request):
        pedidos = Pedidos.objects.all()
        serializer = PedidoSerializer(pedidos, many=True)
        return Response(serializer.data, status=status.HTTP_200_OK)

    def post(self, request):
        serializer = PedidoSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        else:
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


class DetailPedidos(APIView):

    def get(self, request, pk):
        pedido = get_object_or_404(Pedidos, id=pk)
        serializer = PedidoSerializer(pedido)
        return Response(serializer.data, status=status.HTTP_200_OK)

    def put(self, request, pk):
        pedido = get_object_or_404(Pedidos, id=pk)
        serializer = PedidoSerializer(pedido, data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_200_OK)
        else:
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def delete(self, request, pk):
        pedido = get_object_or_404(Pedidos, id=pk)
        pedido.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)


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