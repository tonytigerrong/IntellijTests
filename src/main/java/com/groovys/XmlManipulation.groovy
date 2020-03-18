package com.groovys

import groovy.xml.MarkupBuilder
class XmlManipulation {
    static void main(String[] args) {
/*
        def mB = new MarkupBuilder()
        def moives = mB.collection(shelf: "new arrivals") {
            movie(title: 'Enemy Behind')
            type('War, Thriller')
            format('DVD')
            year('2003')
            rating('PG')
            stars(10)
            description('Talk about a US-Japan war')
        }
    }

 */
        def mp = [1 : ['Enemy Behind', 'War, Thriller','DVD','2003',
                       'PG', '10','Talk about a US-Japan war'],
                  2 : ['Transformers','Anime, Science Fiction','DVD','1989',
                       'R', '8','A scientific fiction'],
                  3 : ['Trigun','Anime, Action','DVD','1986',
                       'PG', '10','Vash the Stam pede'],
                  4 : ['Ishtar','Comedy','VHS','1987', 'PG',
                       '2','Viewable boredom ']]

        def mB = new MarkupBuilder()

        // Compose the builder
        def MOVIEDB = mB.collection('shelf': 'New Arrivals') {
            mp.each {
                sd ->
                    mB.movie('title': sd.value[0]) {
                        type(sd.value[1])
                        format(sd.value[2])
                        year(sd.value[3])
                        rating(sd.value[4])
                        stars(sd.value[5])
                        description(sd.value[6])
                    }
            }
        }

        def parser = new XmlParser()
        def doc = parser.parse("./text.txt");
        doc.movie.each{
            bk->
                print("Movie Name:")
                println "${bk['@title']}"

                print("Movie Type:")
                println "${bk.type[0].text()}"

                print("Movie Format:")
                println "${bk.format[0].text()}"

                print("Movie year:")
                println "${bk.year[0].text()}"

                print("Movie rating:")
                println "${bk.rating[0].text()}"

                print("Movie stars:")
                println "${bk.stars[0].text()}"

                print("Movie description:")
                println "${bk.description[0].text()}"
                println("*******************************")
        }
    }

    }

