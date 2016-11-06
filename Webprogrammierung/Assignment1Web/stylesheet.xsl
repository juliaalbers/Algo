<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/1999/xhtml"
    exclude-result-prefixes="xs"
    version="2.0">
    <xs:output method="html"></xs:output>
    
    <xs:template match="/">
        <html>
            <head>
                <title>
                    Labor Übersicht
                </title>
            </head>
            <body>
                <xs:apply-templates/>
            </body>
        </html>
    </xs:template>
    
    <xs:template match="Labor">
        <h1><xs:value-of select="@Name"/></h1>
        <xs:call-template name="rechner"/>
        <xs:apply-templates/>
    </xs:template>
    
    <xs:template name="rechner" match="Rechner">
        <h3>Eigenschaften</h3>
        <p>ID: <xs:value-of select="ID"/></p>
        <p>Betriebssystem: <xs:value-of select="Betriebssystem"/></p>
        <p>Anschaffung: <xs:value-of select="Anschaffung"/></p>
        <p>Beschreibung: <xs:call-template name="beschreibung"/></p>
        <p>Erweitungeren: <xs:call-template name="erweiterungen"/></p>
        <p>Weitere Geräte: <xs:call-template name="geräte"/></p>
        <p>Software: <xs:call-template name="software"/></p>
    </xs:template>
    
    <xs:template name="beschreibung" match="Beschreibung">
        <xs:copy-of select="text()"/>
    </xs:template>
    
    <xs:template name="erweiterungen" match="Erweiterungen">
        <xs:copy-of select="text()"/>
    </xs:template>
    
    <xs:template name="geräte" match="Gerät">
        <p>ID: <xs:value-of select="ID"/></p>
        <p>Anschaffung: <xs:value-of select="Anschaffung"/></p>
        <p>Beschreibung: <xs:call-template name="beschreibung"/></p>
        <p>Erweiterungen: <p>Erweitungeren: <xs:call-template name="erweiterungen"/></p></p>
        <xs:apply-templates/>
    </xs:template>
    
    <xs:template name="software" match="Software">
        
    </xs:template>
    
</xsl:stylesheet>