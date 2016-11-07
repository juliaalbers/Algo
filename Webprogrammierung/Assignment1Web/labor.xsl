<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    
    <xsl:template match="/">
        <html>
            <body>
                <xsl:element name="h2">Alle Daten zum Labor</xsl:element>
                <xsl:element name="br"/>
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
                    <xsl:for-each select="//Rechner">
                        <xsl:sort select="@Rechner_ID"/>
                        <xsl:element name="tr">
                            <xsl:element name="td">
                                <xsl:element name="a">
                                    <xsl:attribute name="href">
                                        rechner.xsl
                                    </xsl:attribute>
                                <xsl:value-of select="@Rechner_ID"/>
                                </xsl:element>
                            </xsl:element>
                            <xsl:element name="td"><xsl:value-of select="@Betriebssystem"/></xsl:element>
                            <xsl:element name="td"><xsl:value-of select="@Anschaffungsdatum"/></xsl:element>
                        </xsl:element>
                    </xsl:for-each>
                </xsl:element>
                <!-- Zeilenumbruch -->
                <xsl:element name="br"/>
                <xsl:element name="h3">Hersteller</xsl:element>
                <xsl:for-each select="//Labor[position()=1]/*/*/Hersteller">
                    <xsl:sort select="text()"/>
                    <xsl:element name="li"><xsl:value-of select="text()"/></xsl:element>
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
                <xsl:element name="p"><xsl:value-of select="//Labor[position()=1]/*/Installierte_Software"/></xsl:element>
            </body>
        </html>
    </xsl:template>
    
</xsl:stylesheet> 