from django.conf.urls import url, include
import rest_framework_docs

urlpatterns = [
    url(r'^eventos/', include('modules.eventos.urls')),
    url(r'^productos/', include('modules.productos.urls')),
    url(r'^yaDocs/', include('rest_framework_docs.urls')),
]

