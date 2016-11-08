<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <!-- Autoren: Münsterberg, Enno; Albers, Julia; Ioannidis, Niko -->
    
    <xsl:template match="/">
        <html>
            <body>
                <xsl:element name="h2"><a name="anf">Alle Labore der Hochschule</a></xsl:element>
                <!-- Tabelle mit allen Laboren -->
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
                                <!-- Link zum Labor und holen des Attributes Name -->
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
                    <!-- Jede Menge berechnungen zu Anzahlen und Durchschnitt -->
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
                <!-- Tabelle mit allen Betriebssystemen -->
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
                        <xsl:element name="th">Beschreibung</xsl:element>
                        <xsl:element name="th">Besonderheiten</xsl:element>
                    </xsl:element>
                    <xsl:for-each select="//Anwendung">
                        <xsl:sort select="@Name"/>
                        <xsl:element name="tr">
                            <xsl:element name="td"><xsl:value-of select="@Name"/></xsl:element>
                            <xsl:element name="td"><xsl:value-of select="@ID"/></xsl:element>
                            <xsl:element name="td"><xsl:value-of select="Beschreibung"/></xsl:element>
                            <xsl:element name="td"><xsl:value-of select="Besonderheiten"/></xsl:element>
                        </xsl:element>
                    </xsl:for-each>
                </xsl:element>
                <br/>
                <br/>
                <hr/>
                
                <!-- Links für die Labore -->
                <a name="Biologie Labor">
                    <!-- Aufruf zum Template mit parametern -->
                    <xsl:call-template name="lab">
                        <xsl:with-param name="name" select="//Labor[position()=1]"/>
                    </xsl:call-template>
                </a>
                
                <a name="Informatik Labor">
                    <xsl:call-template name="lab">
                        <xsl:with-param name="name" select="//Labor[position()=2]"/>
                    </xsl:call-template>
                </a>
                
                <a name="Multimedialabor">
                    <xsl:call-template name="lab">
                        <xsl:with-param name="name" select="//Labor[position()=3]"/>
                    </xsl:call-template>
                </a>
                
                <!-- Links für die Rechner -->
                <a name="C3013">
                    <!-- Aufruf zum Template mit parametern -->
                    <xsl:call-template name="rech">
                        <xsl:with-param name="name" select="//Labor[position()=1]/Rechner[position()=3]"/>
                        <xsl:with-param name="labor" select="'Biologie Labor'"/>
                    </xsl:call-template>
                </a>
                
                <a name="C2037">
                    <xsl:call-template name="rech">
                        <xsl:with-param name="name" select="//Labor[position()=2]/Rechner[position()=2]"/>
                        <xsl:with-param name="labor" select="'Informatik Labor'"/>
                    </xsl:call-template>
                </a>
                
                <a name="C2013">
                    <xsl:call-template name="rech">
                        <xsl:with-param name="name" select="//Labor[position()=1]/Rechner[position()=2]"/>
                        <xsl:with-param name="labor" select="'Biologie Labor'"/>
                    </xsl:call-template>
                </a>
                
                <a name="C1037">
                    <xsl:call-template name="rech">
                        <xsl:with-param name="name" select="//Labor[position()=2]/Rechner[position()=1]"/>
                        <xsl:with-param name="labor" select="'Informatik Labor'"/>
                    </xsl:call-template>
                </a>
                
                <a name="C1013">
                    <xsl:call-template name="rech">
                        <xsl:with-param name="name" select="//Labor[position()=1]/Rechner[position()=1]"/>
                        <xsl:with-param name="labor" select="'Biologie Labor'"/>
                    </xsl:call-template>
                </a>
                
                <a name="C1003">
                    <xsl:call-template name="rech">
                        <xsl:with-param name="name" select="//Labor[position()=3]/Rechner[position()=1]"/>
                        <xsl:with-param name="labor" select="'Multimedialabor'"/>
                    </xsl:call-template>
                </a>
                
            </body>
        </html>
    </xsl:template>
    
    <xsl:template match="Labor" name="lab">
        <xsl:param name="name" select="@name"/>
        <xsl:element name="h2">Alle Daten zum Labor</xsl:element>
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
            <!-- Bestimmung von dem Labor und Tabelle zu allen Rechnern im Labor -->
            <xsl:for-each select="$name/Rechner"><!-- benutzen des Parameters -->
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
        <xsl:for-each  select="$name/*/*/Hersteller"><!-- benutzen des Parameters -->
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
            <xsl:for-each select="$name/Geraet"><!-- benutzen des Parameters -->
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
        <xsl:for-each select="$name/*/Installierte_Software/Software"><!-- benutzen des Parameters -->
            <xsl:sort select="@ID"/>
            <xsl:element name="li"><xsl:value-of select="@ID"/></xsl:element>
        </xsl:for-each>
        <br/>
        <br/>
        <hr/>
    </xsl:template>
    
    <!-- Rechner 3 -->
    <xsl:template match="Rechner" name="rech">
        <xsl:param name="name" select="@name"/><!-- Parameter -->
        <xsl:param name="labor" select="@labor"/><!-- Parameter -->
        <xsl:element name="h2"><a name="C3013">Alles zu Rechner C3013</a></xsl:element>
        <xsl:element name="br"/>
        <xsl:element name="p"><a href="#anf">Seitenanfang</a></xsl:element>
        <xsl:element name="p"><a href="#{$labor}">Zurück zum Labor</a></xsl:element><!-- benutzen des Parameters -->
        <xsl:element name="h4">Beschreibung</xsl:element>
        <xsl:value-of select="$name/Beschreibung"/><!-- benutzen des Parameters -->
        <xsl:element name="br"/>
        <xsl:element name="h4">Erweiterung</xsl:element>
        <xsl:value-of select="$name/Erweiterung/Beschreibung"/><!-- benutzen des Parameters -->
        <xsl:element name="br"/>
        <xsl:element name="h4">Besonderheiten</xsl:element>
        <xsl:value-of select="$name/Besonderheiten"/><!-- benutzen des Parameters -->
        <xsl:element name="br"/>
        <xsl:element name="h4">Software</xsl:element>
        <xsl:element name="table">
            <xsl:attribute name="border">
                1
            </xsl:attribute>
            <xsl:element name="tr">
                <xsl:attribute name="bgcolor">
                    FF0000
                </xsl:attribute>
                <xsl:element name="th">ID</xsl:element>
                <xsl:element name="th">Lizenz</xsl:element>
            </xsl:element>
            <xsl:for-each select="$name/Installierte_Software/Software"><!-- benutzen des Parameters -->
                <xsl:sort select="@ID"/>
                <xsl:element name="tr">
                    <xsl:element name="td"><xsl:value-of select="@ID"/></xsl:element>
                    <xsl:element name="td"><xsl:value-of select="@Lizenzvorhanden"/></xsl:element>
                </xsl:element>
            </xsl:for-each>
        </xsl:element>
        <br/>
        <br/>
        <hr/>
    </xsl:template>
    
</xsl:stylesheet> 