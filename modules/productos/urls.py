from django.conf.urls import url
from .views import ListPaquetes, ListPedidos, ListProductos, UploadFiles


urlpatterns = [
    url(r'^$', ListProductos.as_view(), name="list-productos"),
    url(r'^paquetes/$', ListPaquetes.as_view(), name="list-paquetes"),
    url(r'^pedidos/$', ListPedidos.as_view(), name="list-pedidos"),
    url(r'^files/$', UploadFiles.as_view()),
]