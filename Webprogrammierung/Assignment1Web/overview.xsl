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
                                        <xsl:value-of select="rechner.xsl"/>
                                    </xsl:attribute>
                                    <xsl:attribute name="target">rechner.xsl</xsl:attribute>
                                    <xsl:value-of select="@Name"/>
                                </xsl:element>
                            </xsl:element>
                            <td><xsl:value-of select="@Raum_Nr"/></td>
                        </xsl:element>
                    </xsl:for-each>
                </xsl:element>
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
                        <xsl:element name="td">Software</xsl:element>
                        <xsl:element name="td"><xsl:value-of select="count(//Betriebssystem)+count(//Anwendung)"/></xsl:element>
                    </xsl:element>
                    <xsl:element name="tr">
                        <xsl:element name="td">Durchschnitt Rechner</xsl:element>
                        <xsl:element name="td"><xsl:value-of select="format-number(count(//Labor) div count(//Rechner), '0.00')"/></xsl:element>
                    </xsl:element>
                </xsl:element>
            </body>
        </html>
    </xsl:template>
    
</xsl:stylesheet> 