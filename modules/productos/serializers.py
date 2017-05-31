from rest_framework import serializers
from .models import Productos, Paquetes, Pedidos


class ProductoSerializer(serializers.ModelSerializer):
    class Meta:
        model = Productos
        fields = '__all__'


class PaqueteSerializer(serializers.ModelSerializer):
    productos = ProductoSerializer(many=True, read_only=True)

    class Meta:
        model = Paquetes
        fields = ('id', 'nombre', 'imagen', 'productos')


class PedidoSerializer(serializers.ModelSerializer):
    paquetes = PaqueteSerializer(many=True, read_only=True)
    productos = ProductoSerializer(many=True, read_only=True)

    class Meta:
        model = Pedidos
        fields = ('id', 'nombre', 'direccion', 'fecha_solicitado', 'hora_entregado', 'paquetes', 'productos')
