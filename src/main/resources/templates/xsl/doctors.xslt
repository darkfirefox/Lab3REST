<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">
<xsl:output method="html" indent="yes" />
<xsl:template match="/">
    <html>
        <body>
            <div align="center">
                <xsl:apply-templates />
            </div>
        </body>
    </html>
</xsl:template>
<xsl:template match="doctors">
    <table border="1" width="100%">
        <tr bgcolor="#eee">
            <th>Id</th>
            <th>Имя</th>
            <th>Отчетсво</th>
            <th>Фамилия</th>
            <th>Специализация</th>
        </tr>
        <xsl:for-each select="doctor">
            <tr>
                <td>
                    <xsl:value-of select="id"/>
                </td>
                <td>
                    <xsl:value-of select="firstname"/>
                </td>
                <td>
                    <xsl:value-of select="fathername"/>
                </td>
                <td>
                    <xsl:value-of select="lastname"/>
                </td>
                <td>
                    <xsl:value-of select="specification"/>
                </td>
            </tr>
        </xsl:for-each>
    </table>
</xsl:template>
</xsl:stylesheet>