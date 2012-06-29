package de.vorb.l10n

class L10n {
  def apply[Lang <: Language](lang: Lang, term: Term) = lang(term)
}
