

Getting started
-----------------

.. The FACPL language has the dedicated web site `facpl.sourceforge.net <http://facpl.sourceforge.net>`__ that provides a full account of the language and its supporting tools. From the web site, it is also accessible the `"Try FACPL in your Browser" <http://150.217.32.61:8080/FACPL-App/index.jsp>`__ web application, that allows newcomer users to experiment with FACPL without installing any software. 

A set of FACPL examples are available in the GitHub repository together with the corresponding
Java-translated policies, in the `code examples
repository <https://github.com/andreamargheri/FACPL/tree/master/EXAMPLES>`__. The binaries
and source code of the Java library and its unit tests can be downloaded
from the repository as well.

Eclipse installation
=====================

.. NOTE:: The Eclipse plugin is provided by means of the Eclipse p2 repository (the current stable version is the 2.0.5). The repository is available in .zip format as part of the last release in GitHub `here <https://github.com/andreamargheri/FACPL/releases>`_.

By using the well-known
procedure "Install new software..." from the Eclipse's toolbar menu, the
FACPL plugin can be easily installed. Note that it is required to accept
the *Eclipse Public License* in order to complete the installation. The
plugin installation requires:

-  Eclipse for Java and DSL Developers version 4.\* or higher version
-  Xtext framework plugins
-  Java 8

If the Xtext plugins are missing, they will be automatically added
through the standard Eclipse update site. 

.. NOTE:: The plugin has been successfully tested by using the Eclipse DSL Release Neon 

Using the tool
~~~~~~~~~~~~~~

When the installation of the plugin has completed, we can create a FACPL
project to start coding, analysing and evaluating FACPL policies. Below,
we briefly outline the creation of FACPL projects and files, introduce
the syntax and semantics of FACPL, its analysis, and conclude by
presenting commands and features of the plugin.


Java Library
=============

Basic examples of FACPL Java code is available in the `Java code examples <https://github.com/andreamargheri/FACPL/tree/master/EXAMPLES/FACPL_JAVA_Examples>`_. 

.. NOTE:: FACPL is not intended to be used directly from Java, but via its high-level syntax (whose IDE is available in the Eclipse plugin). Therefore, the way a policy is constructed is more `friendly` for an automated code generator than a programmer. 

Library structure
~~~~~~~~~~~~~~~~~



Creating a policy
~~~~~~~~~~~~~~~~~



Evaluating a policy
~~~~~~~~~~~~~~~~~~~~




FACPL Parsers and Code Generators
==================================




