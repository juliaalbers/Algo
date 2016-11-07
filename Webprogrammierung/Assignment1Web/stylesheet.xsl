<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    
    <xsl:template match="/">
        <html>
            <body>
                <h2>Alle Labore der Hochschule</h2>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <th>Labor Nummer</th>
                        <th>Labor Name</th>
                        <th>Link</th>
                    </tr>
                    <xsl:for-each select="//Labor">
                        <xsl:sort select="@Raum_Nr"/>
                        <tr>
                            <td>
                                <xsl:element name="a">
                                    <xsl:attribute name="href">
                                        <xsl:value-of select="@Raum_Nr"/>
                                    </xsl:attribute>
                                    <xsl:attribute name="target">_blank</xsl:attribute>
                                    <xsl:value-of select="@Name"/>
                                </xsl:element>
                            </td>
                            <td><xsl:value-of select="@Raum_Nr"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
    
</xsl:stylesheet> 