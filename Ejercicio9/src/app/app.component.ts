import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  nombre = 'Rubén Saiz Molero'
  telefono = '665963820'
  fechaNac = '16/07/1994'
  domicilio = 'C/ Guardias de Corps 1 Portal B Bajo 2 (Aranjuez-Madrid)'
  email = 'rubensaizm@gmail.com'

  forAcadem1 = 'Grado en Ingeniería Informática'
  forAcadem2= 'Técnico Superior en Administración de Sistemas Informáticos en Red'
  forAcadem3 = 'Técnico en Sistemas Microinformáticos y Redes'
  forAcadem4 = 'Educación Secundaria Obligatoria'

  exLab1 = 'Beca Babelcamp en BABEL Sistemas de Información'
  exLab2 = 'FCT Técnico IT en Ayuntamiento de Aranjuez'
  exLab3 = 'FCT Servicio Técnico en Isolux Corsán'

  SO ='Windows, Linux, Android, Cisco OS.'
  lenguajes = 'Java, Python, C, Pascal, HTML, CSS, SQL, JavaScipt.'
  protocolos = 'HTTP, FTP, DNS, DHCP, Telnet, SSH.'
  pruebas = 'Selenium, Jenkins, JUnit5, AssertJ, Hamcrest, Mockito.'
  BBDD = 'Gestores de Base de datos: SQL Server, MySQL.'
  IDE = 'Entornos de programación: Eclipse, IntelliJ, NetBeans, Android Studio, CLion.'
  virtualizacion = 'Virtualización: VirtualBox y VMware.'
  redes = 'Diseño de Redes: Cisco Packet Tracert.'
  remoto = 'Control remoto: VNC, TeamViewer'
  seguridad = 'Seguridad: Firewall Netfilter, IDS Snort, Proxy Squid, Wireshark, Nmap, Netcat.'
  web = 'Diseño Web: Wordpress, Joomla, Spring'
  sweb = 'Servidores Web: IIS y Apache'
  ogl = 'Computación Grafica: OpenGL'
  office = 'Microsoft Office: Word, Excel, PowerPoint, Visio, Project'

  ingles = 'Nivel B1 TOEIC'

}
