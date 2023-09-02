
Book gina  = new Book('Groovy in Action')
assert gina.getTitle() == 'Groovy in Action'

//assert getTitleBackwards(gina) == 'noticA ni yvoorG'

String getTitleBackwards(book)
{
    String title = book.getTitle()
    return title.reverse()
}