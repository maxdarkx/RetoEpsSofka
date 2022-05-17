# language: es

  Característica: Iniciar sesion del usuario juanmaya en la pagina web afiliados sura
    Regla: Debe mostrarse el dashboard de afiliados sura
  Escenario: Juan se loguea en la pagina de afiliados sura
    Dado que Juan es un afiliado de la eps Sura y abre la pagina de login
    Cuando Juan inicia sesion en la pagina con su identificacion tipo "CEDULA", numero "1017131966" y password "1235"
    Entonces Juan observa el dashboard de afiliados de Sura