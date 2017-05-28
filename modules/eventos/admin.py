from django.contrib import admin
from .models import Evento, Invitado, Encuesta


class EventoAdmin(admin.ModelAdmin):
    pass


class InvitadoAdmin(admin.ModelAdmin):
    pass


class EncuestaAdmin(admin.ModelAdmin):
    pass

admin.site.register(Evento, EventoAdmin)
admin.site.register(Invitado, InvitadoAdmin)
admin.site.register(Encuesta, EncuestaAdmin)

