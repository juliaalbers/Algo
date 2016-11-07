<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    
    <xsl:template match="/">
        <html>
            <body>
                <h2>Alle Labore der Hochschule</h2>
                <table border="1">
                    <tr bgcolor="#00BFFF">
                        <th>Rechner Name</th>
                        <th>Betriebssystem</th>
                        <th>Anschaffung</th>
                    </tr>
                    <xsl:for-each select="//Rechner">
                        <xsl:sort select="@Rechner_ID"/>
                        <tr>
                            <td><xsl:value-of select="@Rechner_ID"/></td>
                            <td><xsl:value-of select="@Betriebssystem"/></td>
                            <td><xsl:value-of select="@Anschaffungsdatum"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
    
</xsl:stylesheet> 