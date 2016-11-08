<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    
    <xsl:template match="/">
        <html>
            <body>
                <xsl:element name="h2"><a name="anf">Alle Labore der Hochschule</a></xsl:element>
                <xsl:element name="table">
                    <xsl:attribute name="border">
                        1
                    </xsl:attribute>
                    <xsl:element name="tr">
                        <xsl:attribute name="bgcolor">
                            9acd32
                        </xsl:attribute>
                        <xsl:element name="th">Labor Nummer</xsl:element>
                        <xsl:element name="th">Labor Name</xsl:element>
                    </xsl:element>
                    <xsl:for-each select="//Labor">
                        <xsl:sort select="@Name"/>
                        <xsl:element name="tr">
                            <xsl:element name="td">
                                <a href="#{@Name}"><xsl:value-of select="@Name"/></a>
                            </xsl:element>
                            <td><xsl:value-of select="@Raum_Nr"/></td>
                        </xsl:element>
                    </xsl:for-each>
                </xsl:element>
                <!-- Neue Tabelle vorher br -->
                <xsl:element name="br"/>
                <xsl:element name="h2">Zahlen und Fakten</xsl:element>
                <xsl:element name="table">
                    <xsl:attribute name="border">
                        1
                    </xsl:attribute>
                    <xsl:element name="tr">
                        <xsl:attribute name="bgcolor">
                            00BFFF
                        </xsl:attribute>
                        <xsl:element name="th">Name</xsl:element>
                        <xsl:element name="th">Anzahl</xsl:element>
                    </xsl:element>
                    <xsl:element name="tr">
                        <xsl:element name="td">Labore</xsl:element>
                        <xsl:element name="td"><xsl:value-of select="count(//Labor)"/></xsl:element>
                    </xsl:element>
                    <xsl:element name="tr">
                        <xsl:element name="td">Rechner</xsl:element>
                        <xsl:element name="td"><xsl:value-of select="count(//Rechner)"/></xsl:element>
                    </xsl:element>
                    <xsl:element name="tr">
                        <xsl:element name="td">Betriebssystem</xsl:element>
                        <xsl:element name="td"><xsl:value-of select="count(//Betriebssystem)"/></xsl:element>
                    </xsl:element>
                    <xsl:element name="tr">
                        <xsl:element name="td">Software</xsl:element>
                        <xsl:element name="td"><xsl:value-of select="count(//Anwendung)"/></xsl:element>
                    </xsl:element>
                    <xsl:element name="tr">
                        <xsl:element name="td">Durchschnitt Rechner</xsl:element>
                        <xsl:element name="td"><xsl:value-of select="format-number(count(//Labor) div count(//Rechner), '0.00')"/></xsl:element>
                    </xsl:element>
                </xsl:element>
                <!-- Neue Tabelle vorher br -->
                <xsl:element name="br"/>
                <xsl:element name="h2">Alle Betriebssysteme</xsl:element>
                <xsl:element name="table">
                    <xsl:attribute name="border">
                        1
                    </xsl:attribute>
                    <xsl:element name="tr">
                        <xsl:attribute name="bgcolor">
                            4d79ff
                        </xsl:attribute>
                        <xsl:element name="th">Betriebssysteme</xsl:element>
                        <xsl:element name="th">ID</xsl:element>
                    </xsl:element>
                    <xsl:for-each select="//Betriebssystem">
                        <xsl:sort select="@Name"/>
                        <xsl:element name="tr">
                            <xsl:element name="td">
                                <xsl:value-of select="@Name"/>
                            </xsl:element>
                            <xsl:element name="td"><xsl:value-of select="@ID"/></xsl:element>
                        </xsl:element>
                    </xsl:for-each>
                </xsl:element>
                <!-- Neue Tabelle vorher br -->
                <xsl:element name="br"/>
                <xsl:element name="h2">Alle Anwendungen</xsl:element>
                <xsl:element name="table">
                    <xsl:attribute name="border">
                        1
                    </xsl:attribute>
                    <xsl:element name="tr">
                        <xsl:attribute name="bgcolor">
                            4d4dff
                        </xsl:attribute>
                        <xsl:element name="th">Anwendungen</xsl:element>
                        <xsl:element name="th">ID</xsl:element>
                    </xsl:element>
                    <xsl:for-each select="//Anwendung">
                        <xsl:sort select="@Name"/>
                        <xsl:element name="tr">
                            <xsl:element name="td">
                                <xsl:value-of select="@Name"/>
                            </xsl:element>
                            <xsl:element name="td"><xsl:value-of select="@ID"/></xsl:element>
                        </xsl:element>
                    </xsl:for-each>
                </xsl:element>
                <br/>
                <br/>
                <hr/>
                
                <!-- Labor 1 -->
                <xsl:element name="h2"><a name="Biologie Labor">Alle Daten zum Labor 1</a></xsl:element>
                <xsl:element name="br"/>
                <xsl:element name="p"><a href="#anf">Seitenanfang</a></xsl:element>
                <xsl:element name="h3">Die Rechner</xsl:element>
                <xsl:element name="table">
                    <xsl:attribute name="border">
                        1
                    </xsl:attribute>
                    <xsl:element name="tr">
                        <xsl:attribute name="bgcolor">
                            FFFF00
                        </xsl:attribute>
                        <xsl:element name="th">Rechner</xsl:element>
                        <xsl:element name="th">Betriebssystem</xsl:element>
                        <xsl:element name="th">Anschaffung</xsl:element>
                    </xsl:element>
                    <xsl:for-each select="//Labor[position()=1]/Rechner">
                        <!--<xsl:sort select="@Rechner_ID"/>-->
                        <xsl:element name="tr">
                            <xsl:element name="td"><a href="#{@Rechner_ID}"><xsl:value-of select="@Rechner_ID"/></a></xsl:element>
                            <xsl:element name="td"><xsl:value-of select="@Betriebssystem"/></xsl:element>
                            <xsl:element name="td"><xsl:value-of select="@Anschaffungsdatum"/></xsl:element>
                        </xsl:element>
                    </xsl:for-each>
                </xsl:element>
                <!-- Zeilenumbruch -->
                <xsl:element name="br"/>
                <xsl:element name="h3">Hersteller</xsl:element>
                <xsl:for-each  select="//Labor[position()=1]/*/*/Hersteller">
                    <xsl:sort select="text()"/>
                    <xsl:if test="not(preceding::Hersteller/text() = text())">
                        <xsl:element  name="li"><xsl:value-of select="text()"/></xsl:element>
                    </xsl:if>
                </xsl:for-each>
                <!-- Zeilenumbruch -->
                <xsl:element name="br"/>
                <xsl:element name="h3">Sonstige Geräte</xsl:element>
                <xsl:element name="table">
                    <xsl:attribute name="border">
                        1
                    </xsl:attribute>
                    <xsl:element name="tr">
                        <xsl:attribute name="bgcolor">
                            FFFF00
                        </xsl:attribute>
                        <xsl:element name="th">Gerät</xsl:element>
                        <xsl:element name="th">Anschaffungsdatum</xsl:element>
                    </xsl:element>
                    <xsl:for-each select="//Labor[position()=1]/Geraet">
                        <xsl:sort select="@Geraete_ID"/>
                        <xsl:element name="tr">
                            <xsl:element name="td"><xsl:value-of select="@Geraete_ID"/></xsl:element>
                            <xsl:element name="td"><xsl:value-of select="@Anschaffungsdatum"/></xsl:element>
                        </xsl:element>
                    </xsl:for-each>
                </xsl:element>
                <!-- Zeilenumbruch -->
                <xsl:element name="br"/>
                <xsl:element name="h3">Installierte Software</xsl:element>
                <xsl:for-each select="//Labor[position()=1]/*/Installierte_Software/Software">
                    <xsl:sort select="@ID"/>
                    <xsl:element name="li"><xsl:value-of select="@ID"/></xsl:element>
                </xsl:for-each>
                <br/>
                <br/>
                <hr/>
                
                <!-- Labor 2 -->
                <xsl:element name="h2"><a name="Informatik Labor">Alle Daten zum Labor 2</a></xsl:element>
                <xsl:element name="br"/>
                <xsl:element name="p"><a href="#anf">Seitenanfang</a></xsl:element>
                <xsl:element name="h3">Die Rechner</xsl:element>
                <xsl:element name="table">
                    <xsl:attribute name="border">
                        1
                    </xsl:attribute>
                    <xsl:element name="tr">
                        <xsl:attribute name="bgcolor">
                            FFFF00
                        </xsl:attribute>
                        <xsl:element name="th">Rechner</xsl:element>
                        <xsl:element name="th">Betriebssystem</xsl:element>
                        <xsl:element name="th">Anschaffung</xsl:element>
                    </xsl:element>
                    <xsl:for-each select="//Labor[position()=2]/Rechner">
                        <xsl:sort select="@Rechner_ID"/>
                        <xsl:element name="tr">
                            <xsl:element name="td"><a href="#{@Rechner_ID}"><xsl:value-of select="@Rechner_ID"/></a></xsl:element>
                            <xsl:element name="td"><xsl:value-of select="@Betriebssystem"/></xsl:element>
                            <xsl:element name="td"><xsl:value-of select="@Anschaffungsdatum"/></xsl:element>
                        </xsl:element>
                    </xsl:for-each>
                </xsl:element>
                <!-- Zeilenumbruch -->
                <xsl:element name="br"/>
                <xsl:element name="h3">Hersteller</xsl:element>
                <xsl:for-each select="//Labor[position()=2]/*/*/Hersteller">
                    <xsl:sort select="text()"/>
                    <xsl:if test="not(preceding::Hersteller/text() = text())">
                        <xsl:element  name="li"><xsl:value-of select="text()"/></xsl:element>
                    </xsl:if>
                </xsl:for-each>
                <!-- Zeilenumbruch -->
                <xsl:element name="br"/>
                <xsl:element name="h3">Sonstige Geräte</xsl:element>
                <xsl:element name="table">
                    <xsl:attribute name="border">
                        1
                    </xsl:attribute>
                    <xsl:element name="tr">
                        <xsl:attribute name="bgcolor">
                            FFFF00
                        </xsl:attribute>
                        <xsl:element name="th">Gerät</xsl:element>
                        <xsl:element name="th">Anschaffungsdatum</xsl:element>
                    </xsl:element>
                    <xsl:for-each select="//Labor[position()=2]/Geraet">
                        <xsl:sort select="@Geraete_ID"/>
                        <xsl:element name="tr">
                            <xsl:element name="td"><xsl:value-of select="@Geraete_ID"/></xsl:element>
                            <xsl:element name="td"><xsl:value-of select="@Anschaffungsdatum"/></xsl:element>
                        </xsl:element>
                    </xsl:for-each>
                </xsl:element>
                <!-- Zeilenumbruch -->
                <xsl:element name="br"/>
                <xsl:element name="h3">Installierte Software</xsl:element>
                <xsl:for-each select="//Labor[position()=2]/*/Installierte_Software/Software">
                    <xsl:sort select="@ID"/>
                    <xsl:element name="li"><xsl:value-of select="@ID"/></xsl:element>
                </xsl:for-each>
                <br/>
                <br/>
                <hr/>
                
                <!-- Labor 3 -->
                <xsl:element name="h2"><a name="Multimedialabor">Alle Daten zum Labor 3</a></xsl:element>
                <xsl:element name="br"/>
                <xsl:element name="p"><a href="#anf">Seitenanfang</a></xsl:element>
                <xsl:element name="h3">Die Rechner</xsl:element>
                <xsl:element name="table">
                    <xsl:attribute name="border">
                        1
                    </xsl:attribute>
                    <xsl:element name="tr">
                        <xsl:attribute name="bgcolor">
                            FFFF00
                        </xsl:attribute>
                        <xsl:element name="th">Rechner</xsl:element>
                        <xsl:element name="th">Betriebssystem</xsl:element>
                        <xsl:element name="th">Anschaffung</xsl:element>
                    </xsl:element>
                    <xsl:for-each select="//Labor[position()=3]/Rechner">
                        <xsl:sort select="@Rechner_ID"/>
                        <xsl:element name="tr">
                            <xsl:element name="td"><a href="#{@Rechner_ID}"><xsl:value-of select="@Rechner_ID"/></a></xsl:element>
                            <xsl:element name="td"><xsl:value-of select="@Betriebssystem"/></xsl:element>
                            <xsl:element name="td"><xsl:value-of select="@Anschaffungsdatum"/></xsl:element>
                        </xsl:element>
                    </xsl:for-each>
                </xsl:element>
                <!-- Zeilenumbruch -->
                <xsl:element name="br"/>
                <xsl:element name="h3">Hersteller</xsl:element>
                <xsl:for-each select="//Labor[position()=3]/*/*/Hersteller">
                    <xsl:sort select="text()"/>
                    <xsl:if test="not(preceding::Hersteller/text() = text())">
                        <xsl:element  name="li"><xsl:value-of select="text()"/></xsl:element>
                    </xsl:if>
                </xsl:for-each>
                <!-- Zeilenumbruch -->
                <xsl:element name="br"/>
                <xsl:element name="h3">Sonstige Geräte</xsl:element>
                <xsl:element name="table">
                    <xsl:attribute name="border">
                        1
                    </xsl:attribute>
                    <xsl:element name="tr">
                        <xsl:attribute name="bgcolor">
                            FFFF00
                        </xsl:attribute>
                        <xsl:element name="th">Gerät</xsl:element>
                        <xsl:element name="th">Anschaffungsdatum</xsl:element>
                    </xsl:element>
                    <xsl:for-each select="//Labor[position()=3]/Geraet">
                        <xsl:sort select="@Geraete_ID"/>
                        <xsl:element name="tr">
                            <xsl:element name="td"><xsl:value-of select="@Geraete_ID"/></xsl:element>
                            <xsl:element name="td"><xsl:value-of select="@Anschaffungsdatum"/></xsl:element>
                        </xsl:element>
                    </xsl:for-each>
                </xsl:element>
                <!-- Zeilenumbruch -->
                <xsl:element name="br"/>
                <xsl:element name="h3">Installierte Software</xsl:element>
                <xsl:for-each select="//Labor[position()=3]/*/Installierte_Software/Software">
                    <xsl:sort select="@ID"/>
                    <xsl:element name="li"><xsl:value-of select="@ID"/></xsl:element>
                </xsl:for-each>
                <br/>
                <br/>
                <hr/>
                
                <!-- Rechner 6 -->
                <xsl:element name="h2"><a name="C1003">Alles zu Rechner C1003</a></xsl:element>
                <xsl:element name="br"/>
                <xsl:element name="p"><a href="#anf">Seitenanfang</a></xsl:element>
                <xsl:element name="h4">Beschreibung</xsl:element>
                <xsl:value-of select="//Labor[position()=3]/Rechner[position()=1]/Beschreibung"/>
                <xsl:element name="br"/>
                <xsl:element name="h4">Erweiterung</xsl:element>
                <xsl:value-of select="//Labor[position()=3]/Rechner[position()=1]/Erweiterung/Beschreibung"/>
                <xsl:element name="br"/>
                <xsl:element name="h4">Besonderheiten</xsl:element>
                <xsl:value-of select="//Labor[position()=3]/Rechner[position()=1]/Besonderheiten"/>
                <xsl:element name="br"/>
                <xsl:element name="h4">Software</xsl:element>
                <xsl:for-each select="//Labor[position()=3]/Rechner[position()=1]/Installierte_Software/Software">
                    <xsl:element name="li"><xsl:value-of select="@ID"/></xsl:element>
                </xsl:for-each>
                <br/>
                <br/>
                <hr/>
                
                <!-- Rechner 1 -->
                <xsl:element name="h2"><a name="C1013">Alles zu Rechner C1013</a></xsl:element>
                <xsl:element name="br"/>
                <xsl:element name="p"><a href="#anf">Seitenanfang</a></xsl:element>
                <xsl:element name="h4">Beschreibung</xsl:element>
                <xsl:value-of select="//Labor[position()=1]/Rechner[position()=1]/Beschreibung"/>
                <xsl:element name="br"/>
                <xsl:element name="h4">Erweiterung</xsl:element>
                <xsl:value-of select="//Labor[position()=1]/Rechner[position()=1]/Erweiterung/Beschreibung"/>
                <xsl:element name="br"/>
                <xsl:element name="h4">Besonderheiten</xsl:element>
                <xsl:value-of select="//Labor[position()=1]/Rechner[position()=1]/Besonderheiten"/>
                <xsl:element name="br"/>
                <xsl:element name="h4">Software</xsl:element>
                <xsl:for-each select="//Labor[position()=1]/Rechner[position()=1]/Installierte_Software/Software">
                    <xsl:element name="li"><xsl:value-of select="@ID"/></xsl:element>
                </xsl:for-each>
                <br/>
                <br/>
                <hr/>
                
                <!-- Rechner 4 -->
                <xsl:element name="h2"><a name="C1037">Alles zu Rechner C1037</a></xsl:element>
                <xsl:element name="br"/>
                <xsl:element name="p"><a href="#anf">Seitenanfang</a></xsl:element>
                <xsl:element name="h4">Beschreibung</xsl:element>
                <xsl:value-of select="//Labor[position()=2]/Rechner[position()=1]/Beschreibung"/>
                <xsl:element name="br"/>
                <xsl:element name="h4">Erweiterung</xsl:element>
                <xsl:value-of select="//Labor[position()=2]/Rechner[position()=1]/Erweiterung/Beschreibung"/>
                <xsl:element name="br"/>
                <xsl:element name="h4">Besonderheiten</xsl:element>
                <xsl:value-of select="//Labor[position()=2]/Rechner[position()=1]/Besonderheiten"/>
                <xsl:element name="br"/>
                <xsl:element name="h4">Software</xsl:element>
                <xsl:for-each select="//Labor[position()=2]/Rechner[position()=1]/Installierte_Software/Software">
                    <xsl:element name="li"><xsl:value-of select="@ID"/></xsl:element>
                </xsl:for-each>
                <br/>
                <br/>
                <hr/>
                
                <!-- Rechner 2 -->
                <xsl:element name="h2"><a name="C2013">Alles zu Rechner C2013</a></xsl:element>
                <xsl:element name="br"/>
                <xsl:element name="p"><a href="#anf">Seitenanfang</a></xsl:element>
                <xsl:element name="h4">Beschreibung</xsl:element>
                <xsl:value-of select="//Labor[position()=1]/Rechner[position()=2]/Beschreibung"/>
                <xsl:element name="br"/>
                <xsl:element name="h4">Erweiterung</xsl:element>
                <xsl:value-of select="//Labor[position()=1]/Rechner[position()=2]/Erweiterung/Beschreibung"/>
                <xsl:element name="br"/>
                <xsl:element name="h4">Besonderheiten</xsl:element>
                <xsl:value-of select="//Labor[position()=1]/Rechner[position()=2]/Besonderheiten"/>
                <xsl:element name="br"/>
                <xsl:element name="h4">Software</xsl:element>
                <xsl:for-each select="//Labor[position()=1]/Rechner[position()=2]/Installierte_Software/Software">
                    <xsl:element name="li"><xsl:value-of select="@ID"/></xsl:element>
                </xsl:for-each>
                <br/>
                <br/>
                <hr/>
                
                <!-- Rechner 5 -->
                <xsl:element name="h2"><a name="C2037">Alles zu Rechner C2037</a></xsl:element>
                <xsl:element name="br"/>
                <xsl:element name="p"><a href="#anf">Seitenanfang</a></xsl:element>
                <xsl:element name="h4">Beschreibung</xsl:element>
                <xsl:value-of select="//Labor[position()=2]/Rechner[position()=2]/Beschreibung"/>
                <xsl:element name="br"/>
                <xsl:element name="h4">Erweiterung</xsl:element>
                <xsl:value-of select="//Labor[position()=2]/Rechner[position()=2]/Erweiterung/Beschreibung"/>
                <xsl:element name="br"/>
                <xsl:element name="h4">Besonderheiten</xsl:element>
                <xsl:value-of select="//Labor[position()=2]/Rechner[position()=2]/Besonderheiten/text()"/>
                <xsl:element name="br"/>
                <xsl:element name="h4">Software</xsl:element>
                <xsl:for-each select="//Labor[position()=2]/Rechner[position()=2]/Installierte_Software/Software">
                    <xsl:element name="li"><xsl:value-of select="@ID"/></xsl:element>
                </xsl:for-each>
                <br/>
                <br/>
                <hr/>
                
                <!-- Rechner 3 -->
                <xsl:element name="h2"><a name="C3013">Alles zu Rechner C3013</a></xsl:element>
                <xsl:element name="br"/>
                <xsl:element name="p"><a href="#anf">Seitenanfang</a></xsl:element>
                <xsl:element name="h4">Beschreibung</xsl:element>
                <xsl:value-of select="//Labor[position()=1]/Rechner[position()=3]/Beschreibung"/>
                <xsl:element name="br"/>
                <xsl:element name="h4">Erweiterung</xsl:element>
                <xsl:value-of select="//Labor[position()=1]/Rechner[position()=3]/Erweiterung/Beschreibung"/>
                <xsl:element name="br"/>
                <xsl:element name="h4">Besonderheiten</xsl:element>
                <xsl:value-of select="//Labor[position()=1]/Rechner[position()=3]/Besonderheiten"/>
                <xsl:element name="br"/>
                <xsl:element name="h4">Software</xsl:element>
                <xsl:for-each select="//Labor[position()=1]/Rechner[position()=3]/Installierte_Software/Software">
                    <xsl:element name="li"><xsl:value-of select="@ID"/></xsl:element>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>
    
</xsl:stylesheet> 