Multilingual
============

Tiny i18n/l10n Framework for Scala and the JVM


Usage
-----

You have to define an object, that contains all the terms you want to use in
multiple languages. It must extend `de.vorb.l10n.Term`, which itself extends
`Enumertation`.

``` scala
package org.example.app.l10n

object Term extends de.vorb.l10n.Term {
  val Welcome = Value
  val Bye = Value
  // ...
}
```

Now you have to define the language objects, which extend
`de.vorb.l10n.Language`. They must
implement the methods `def code: String` (language/country code as specifiend by
[RFC 4647](http://tools.ietf.org/html/rfc4647)), `def name: String` (name of
the language), and `override def translate[Term](term: Term)` with a simple
pattern match.

``` scala
package org.example.app.l10n

object en_US extends de.vorb.l10n.Language {
  def code = "en-US"
  def name = "English (United States)"
  override def translate[Term](term: Term) = term match {
    case Term.Welcome => "Welcome"
    case Term.Bye     => "Goodbye"
    // ...
  }
}

object de_DE extends de.vorb.l10n.Language {
  def code = "de-DE"
  def name = "Deutsch (Deutschland)"
  override def translate[Term](term: Term) = term match {
    case Term.Welcome => "Willkommen"
    case Term.Bye     => "Auf Wiedersehen"
    // ...
  }
}
```

You can choose the language that you want to use by assigning the language to a
public `val`. The name of the `val` is used like the name of the method for
translating a term.

``` scala
val translate = de_DE // or en_US

val welcome = translate(Term.Welcome)

println(welcome) // this will print "Willkommen"
```

You can also let the system decide which language to use, for example in a
`package object`:

``` scala
package org.example.app.l10n

import java.util.Locale

package object l10n {
  val defaultLanguage = en_US
  val languages = Map(
    "en_US" -> en_US,
    "en" -> en_US,
    "de_DE" -> de_DE,
    "de" -> de_DE
  )

  // get default system loacle and select language accordingly
  val locale = Locale.getDefault.toString

  // if the default locale doesn't exist among the translation languages, use
  // the default translation language
  val translate = languages.getOrElse(locale, defaultLanguage)
}
```

License
-------

Copyright © 2012 Paul Vorbach

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the “Software”), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, OUT OF OR IN CONNECTION WITH THE
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
