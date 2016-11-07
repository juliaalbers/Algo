<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    
    <xsl:template match="/">
        <html>
            <body>
                <xsl:element name="h2">Alles zu diesem Rechner</xsl:element>
                <xsl:element name="h4">Beschreibung</xsl:element>
                <xsl:for-each select="//Rechner[position()=1]/Beschreibung/node()">
                    <xsl:value-of select="text()"/>
                </xsl:for-each>
                <xsl:element name="br"/>
                <xsl:element name="h4">Erweiterung</xsl:element>
                <xsl:for-each select="//Rechner[position()=1]/Erweiterung/Beschreibung/node()">
                    <xsl:value-of select="text()"/>
                </xsl:for-each>
                <xsl:element name="br"/>
                <xsl:element name="h4">Besonderheiten</xsl:element>
                <xsl:value-of select="//Rechner[position()=1]/Besonderheiten/text()"/>
            </body>
        </html>
    </xsl:template>
    
</xsl:stylesheet> 