import {useEffect, useState} from 'react'
import {IndexBar, List} from 'antd-mobile'
import {useHistory} from 'umi'
import {useDispatch} from 'umi'

export default function City() {
  const history = useHistory()
  const dispatch = useDispatch()
  const [list, setList] = useState<any>([])
  const filterCity = (cities: any) => {
    console.log(cities)
    const letterArr: Array<string> = []
    const newList = []
    for (let i = 65; i < 91; i++) {
      letterArr.push(String.fromCharCode(i))
    }
    // console.log()
    for (let m in letterArr) {
      let cityitems: any = cities.filter((item: any) => item.pinyin.substring(0, 1).toUpperCase() === letterArr[m])
      cityitems.length && newList.push({
        title: letterArr[m],
        items: cityitems
      })
    }
    // console.log(newlist)

    return newList
  }

  useEffect(() => {
    fetch("https://m.maizuo.com/gateway?k=2145459", {
      headers: {
        'X-Client-Info': '{"a":"3000","ch":"1002","v":"5.2.0","e":"16395416565231270166529","bc":"110100"}',
        'X-Host': 'mall.film-ticket.city.list'
      }
    })
      .then(res => res.json())
      .then(res => {
        // console.log(res.data.cities)
        setList(filterCity(res.data.cities))
      })
  }, [])

  const changeCity = (item) => {
    console.log(item.name, item.cityId)
    dispatch({
      type: 'CityModel/changeCity',
      payload: {
        cityName: item.name,
        cityId: item.cityId
      }
    })
    history.push("/cinema")
  }
  return (
    <div style={{height: window.innerHeight}}>
      <IndexBar>
        {list.map((item: any) => {
          const {title, items} = item
          return (
            <IndexBar.Panel
              index={title}
              title={title}
              key={title}
            >
              <List>
                {items.map((item: any, index: number) => (
                  <List.Item key={index} onClick={() => changeCity(item)}>{item.name}</List.Item>
                ))}
              </List>
            </IndexBar.Panel>
          )
        })}
      </IndexBar>
    </div>
  )
}
