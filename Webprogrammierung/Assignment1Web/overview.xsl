<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    
    <xsl:template match="/">
        <html>
            <body>
                <xsl:element name="h2">Alle Labore der Hochschule</xsl:element>
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
                                <xsl:element name="a">
                                    <xsl:attribute name="href">
                                        rechner.xsl
                                    </xsl:attribute>
                                    <xsl:value-of select="@Name"/>
                                </xsl:element>
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
            </body>
        </html>
    </xsl:template>
    
</xsl:stylesheet> 