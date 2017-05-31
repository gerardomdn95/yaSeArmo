from django.conf.urls import url
from .views import ListEventos, ListEncuestas, UploadFiles, ListInvitados, DetailInvitados, \
    ListUsers, DetailEvento, DetailEncuesta, DetailUsers

urlpatterns = [
    url(r'^$', ListEventos.as_view(), name='list-eventos'),
    url(r'^(?P<pk>[0-9]+)/$', DetailEvento.as_view()),
    url(r'^invitados/$', ListInvitados.as_view(), name='list-invitados'),
    url(r'^invitados/(?P<pk>[0-9]+)/$', DetailInvitados.as_view()),
    url(r'^invitados/files/$', UploadFiles.as_view(), name='list-invitados'),
    url(r'^encuestas/$', ListEncuestas.as_view(), name='list-encuesta'),
    url(r'^encuestas/(?P<pk>[0-9]+)/$', DetailEncuesta.as_view()),
    url(r'^users/$', ListUsers.as_view(), name='list-users'),
    url(r'^users/(?P<pk>[0-9]+)/$', DetailUsers.as_view()),
    url(r'^files/$', UploadFiles.as_view()),
]
# DUDA: ¿cómo subir imagenes y como saber a que imagen me refiero (invitado o evento)?
