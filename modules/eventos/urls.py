from django.conf.urls import url
from .views import ListEventos, ListInvitados, ListEncuesta, UploadFiles

urlpatterns = [
    url(r'^$', ListEventos.as_view(), name='list-eventos'),
    url(r'^invitados/$', ListInvitados.as_view(), name='list-invitados'),
    url(r'^encuesta/$', ListEncuesta.as_view(), name='list-encuesta'),
    url(r'^files/$', UploadFiles.as_view()),
]