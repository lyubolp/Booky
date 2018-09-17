# Example 1 - Request a book by ID:

## Message sent:

```json
{  
    "MC":1,
    "ID":1
}
```

## Message received:

```json
{  
    "S":1,
    "R":{  
        "book":{  
            "id":1,
            "chapters":0,
            "series_id":1,
            "publish_year":1984,
            "language_id":16,
            "country_id":40,
            "rating":0,
            "rating_count":0,
            "finished_count":0,
            "reading_count":0,
            "wishlist_count":0,
            "dropped_count":0,
            "onhold_count":0,
            "cover":"",
            "review_count":0
        },
        "authors":[  
            {  
                "author":{  
                    "id":1,
                    "born_year":0,
                    "died_year":0,
                    "country_id":40,
                    "picture":"",
                    "rating":0,
                    "rating_count":0
                },
                "translation":{  
                    "name":{  
                        "special":"",
                        "en":"",
                        "bg":"Дейвид Едингс"
                    },
                    "pen_name":{  
                        "special":"",
                        "en":"",
                        "bg":""
                    }
                },
                "country":{  
                    "special":"us",
                    "en":"United States",
                    "bg":"Съединените щати"
                }
            }
        ],
        "tags":[  
            {  
                "special":"",
                "en":"",
                "bg":"Роман"
            },
            {  
                "special":"",
                "en":"",
                "bg":"Фентъзи"
            },
            {  
                "special":"",
                "en":"",
                "bg":"Епическо фентъзи"
            }
        ],
        "series":{  
            "special":"",
            "en":"",
            "bg":"Белгариада"
        },
        "translation":{  
            "special":"",
            "en":"",
            "bg":"Черната кула"
        },
        "language":{  
            "special":"en",
            "en":"English",
            "bg":"английски"
        },
        "country":{  
            "special":"us",
            "en":"United States",
            "bg":"Съединените щати"
        }
    }
}
```

# Example 2 - Request an author by ID:

## Message sent:

```json
{  
    "MC":2,
    "ID":1
}
```

## Message received:

```json
{  
    "S":1,
    "R":{  
        "author":{  
            "id":1,
            "born_year":0,
            "died_year":0,
            "country_id":40,
            "picture":"",
            "rating":0,
            "rating_count":0
        },
        "translation":{  
            "name":{  
                "special":"",
                "en":"",
                "bg":"Дейвид Едингс"
            },
            "pen_name":{  
                "special":"",
                "en":"",
                "bg":""
            }
        },
        "country":{  
            "special":"us",
            "en":"United States",
            "bg":"Съединените щати"
        }
    }
}
```

# Example 3 - Request all tags:

## Message sent:

```json
{  
    "MC":3
}
```

## Message received (omitted some results which follow the same template to reduce size of the example):

```json
{  
    "S":1,
    "R":[  
        {  
            "item_id":1,
            "special":"",
            "en":"",
            "bg":"Роман"
        },
        {  
            "item_id":2,
            "special":"",
            "en":"",
            "bg":"Фентъзи"
        },
        {  
            "item_id":3,
            "special":"",
            "en":"",
            "bg":"Епическо фентъзи"
        },
        {  
            "item_id":4,
            "special":"",
            "en":"",
            "bg":"Разказ"
        },
        {  
            "item_id":5,
            "special":"",
            "en":"",
            "bg":"Научна фантастика"
        },
        {  
            "item_id":6,
            "special":"",
            "en":"",
            "bg":"Новела"
        },        {  
            "item_id":453,
            "special":"",
            "en":"",
            "bg":"Ода"
        },
        {  
            "item_id":454,
            "special":"",
            "en":"",
            "bg":"Дипломатически игри"
        }
    ]
}
```

# Example 4 - Request a number of books by ID:

## Message sent:

```json
{  
    "MC":4,
    "IDS":[  
        1,
        2,
        39
    ]
}
```

## Message received (omitted some results which follow the same template to reduce size of the example):

```json
{  
    "S":1,
    "R":[  
        {  
            "book":{  
                "id":1,
                "chapters":0,
                "series_id":1,
                "publish_year":1984,
                "language_id":16,
                "country_id":40,
                "rating":0,
                "rating_count":0,
                "finished_count":0,
                "reading_count":0,
                "wishlist_count":0,
                "dropped_count":0,
                "onhold_count":0,
                "cover":"",
                "review_count":0
            },
            "authors":[  
                {  
                    "author":{  
                        "id":1,
                        "born_year":0,
                        "died_year":0,
                        "country_id":40,
                        "picture":"",
                        "rating":0,
                        "rating_count":0
                    },
                    "translation":{  
                        "name":{  
                            "special":"",
                            "en":"",
                            "bg":"Дейвид Едингс"
                        },
                        "pen_name":{  
                            "special":"",
                            "en":"",
                            "bg":""
                        }
                    },
                    "country":{  
                        "special":"us",
                        "en":"United States",
                        "bg":"Съединените щати"
                    }
                }
            ],
            "tags":[  
                {  
                    "special":"",
                    "en":"",
                    "bg":"Роман"
                },
                {  
                    "special":"",
                    "en":"",
                    "bg":"Фентъзи"
                },
                {  
                    "special":"",
                    "en":"",
                    "bg":"Епическо фентъзи"
                }
            ],
            "series":{  
                "special":"",
                "en":"",
                "bg":"Белгариада"
            },
            "translation":{  
                "special":"",
                "en":"",
                "bg":"Черната кула"
            },
            "language":{  
                "special":"en",
                "en":"English",
                "bg":"английски"
            },
            "country":{  
                "special":"us",
                "en":"United States",
                "bg":"Съединените щати"
            }
        },
        {  
            "book":{  
                "id":2,
                "chapters":0,
                "series_id":1,
                "publish_year":1984,
                "language_id":0,
                "country_id":0,
                "rating":0,
                "rating_count":0,
                "finished_count":0,
                "reading_count":0,
                "wishlist_count":0,
                "dropped_count":0,
                "onhold_count":0,
                "cover":"",
                "review_count":0
            },
            "authors":[  
                {  
                    "author":{  
                        "id":1,
                        "born_year":0,
                        "died_year":0,
                        "country_id":40,
                        "picture":"",
                        "rating":0,
                        "rating_count":0
                    },
                    "translation":{  
                        "name":{  
                            "special":"",
                            "en":"",
                            "bg":"Дейвид Едингс"
                        },
                        "pen_name":{  
                            "special":"",
                            "en":"",
                            "bg":""
                        }
                    },
                    "country":{  
                        "special":"us",
                        "en":"United States",
                        "bg":"Съединените щати"
                    }
                }
            ],
            "tags":[  
                {  
                    "special":"",
                    "en":"",
                    "bg":"Роман"
                },
                {  
                    "special":"",
                    "en":"",
                    "bg":"Фентъзи"
                },
                {  
                    "special":"",
                    "en":"",
                    "bg":"Епическо фентъзи"
                }
            ],
            "series":{  
                "special":"",
                "en":"",
                "bg":"Белгариада"
            },
            "translation":{  
                "special":"",
                "en":"",
                "bg":"Последната битка"
            }
        },
        {  
            "book":{  
                "id":39,
                "chapters":0,
                "series_id":0,
                "publish_year":1948,
                "language_id":0,
                "country_id":0,
                "rating":0,
                "rating_count":0,
                "finished_count":0,
                "reading_count":0,
                "wishlist_count":0,
                "dropped_count":0,
                "onhold_count":0,
                "cover":"",
                "review_count":0
            },
            "authors":[  
                {  
                    "author":{  
                        "id":19,
                        "born_year":0,
                        "died_year":0,
                        "country_id":0,
                        "picture":"",
                        "rating":0,
                        "rating_count":0
                    },
                    "translation":{  
                        "name":{  
                            "special":"",
                            "en":"",
                            "bg":"Алфред ван Вогт"
                        },
                        "pen_name":{  
                            "special":"",
                            "en":"",
                            "bg":""
                        }
                    }
                }
            ],
            "tags":[  
                {  
                    "special":"",
                    "en":"",
                    "bg":"Разказ"
                },
                {  
                    "special":"",
                    "en":"",
                    "bg":"Научна фантастика"
                }
            ],
            "translation":{  
                "special":"",
                "en":"",
                "bg":"Чудовището"
            }
        }
    ]
}
```

