from django.contrib import admin
from .models import Productos, Pedidos, Paquetes


class ProductosAdmin(admin.ModelAdmin):
    pass


class PedidosAdmin(admin.ModelAdmin):
    pass


class PaquetesAdmin(admin.ModelAdmin):
    pass

admin.site.register(Productos, ProductosAdmin)
admin.site.register(Paquetes, PaquetesAdmin)
admin.site.register(Pedidos, PedidosAdmin)



